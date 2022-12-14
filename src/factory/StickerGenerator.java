package factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import factory.classification.Classification;
import factory.classification.Rating;

public class StickerGenerator {
	
	public static void producer(URL imageUrl, String title, Rating rating) {

		var evaluation = StickerGenerator.evaluationGenerator(rating);
		
		try {
			BufferedImage poster = ImageIO.read(imageUrl);
			int fifteenPerCentOfPosterHeight = (poster.getHeight() * 15/100);
			BufferedImage sticker = new BufferedImage(poster.getWidth(), poster.getHeight() + fifteenPerCentOfPosterHeight, BufferedImage.TRANSLUCENT);
			Graphics2D graphics = sticker.createGraphics();
			
			var font = new Font(Font.SANS_SERIF, Font.BOLD, (poster.getWidth() * 10/100));
			graphics.drawImage(poster, 0, 0, null);	
			graphics.setFont(font);
			graphics.setColor(Color.YELLOW);
			
			int centerOfSticker = sticker.getWidth() / 2;
			int centerOfText = (graphics.getFontMetrics().stringWidth(evaluation) / 2);
			var stars = Scalr.resize(rating.getStars(), sticker.getWidth() * 90/100);
			
			graphics.drawString(evaluation, centerOfSticker - centerOfText, sticker.getHeight() - (fifteenPerCentOfPosterHeight/2));
			graphics.drawImage(stars, centerOfSticker - (stars.getWidth() / 2), sticker.getHeight() - (fifteenPerCentOfPosterHeight/2) + 10, null);
			
			File path = new File(Path.of("").toAbsolutePath().toString().split("/bin")[0] + "/output");			
			if (!path.exists()) {
				path.mkdir();
				ImageIO.write(sticker, "png", new File(path + "/" + title + ".png"));
			} else {
				ImageIO.write(sticker, "png", new File(path + "/" + title + ".png"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static String evaluationGenerator(Rating rating) {
		String evaluation;
		if (rating.getClassification() == Classification.AWFUL) {
			evaluation = "N??o perca tempo";
		} else if (rating.getClassification() == Classification.MEDIOCRE) {
			evaluation = "Poderia ser melhor";
		} else if (rating.getClassification() == Classification.GOOD) {
			evaluation = "Bom";
		} else {
			evaluation = "N??o deixe de ver";
		}
		return evaluation;
	}
	
}