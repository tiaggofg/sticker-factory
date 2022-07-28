package factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class StickerGenerator {

	public static void producer(URL imageUrl, String title) throws IOException {
		
		BufferedImage img = ImageIO.read(imageUrl);
		BufferedImage newImg = new BufferedImage(img.getWidth(),img.getHeight() + 200, BufferedImage.TRANSLUCENT);
		Graphics2D graphics = newImg.createGraphics();
		
		graphics.drawImage(img, 0, 0, null);
		
		var font = new Font(Font.SANS_SERIF, Font.BOLD, 32);
		graphics.setFont(font);
		graphics.setColor(Color.YELLOW);
		
		String avaliacao = "topzera";

		graphics.drawString(avaliacao, (newImg.getWidth() / 2) - (graphics.getFontMetrics().stringWidth(avaliacao) / 2), newImg.getHeight() - 100);
		
		File path = new File(Path.of("").toAbsolutePath().toString() + "/output");
		
		if (!path.exists()) {
			path.mkdir();
			ImageIO.write(newImg, "png", new File(path + "/" + title + ".png"));
		} else {
			ImageIO.write(newImg, "png", new File(path + "/" + title + ".png"));
		}
		
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		StickerGenerator.producer(new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@..jpg"), "imagem");
	}

}