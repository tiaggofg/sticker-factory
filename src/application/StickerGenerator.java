package application;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class StickerGenerator {

	public static void producer(URL imageUrl) throws IOException {
		
		BufferedImage img = ImageIO.read(imageUrl);
		BufferedImage newImg = new BufferedImage(img.getWidth(),img.getHeight() + 200, BufferedImage.TRANSLUCENT);
		
		Graphics2D graphics = newImg.createGraphics();
		graphics.drawImage(img, 0, 0, null);
		
		File path = new File(Path.of("").toAbsolutePath().toString() + "/output");
		
		if (!path.exists()) {
			path.mkdir();
			ImageIO.write(newImg, "png", new File(path + "/img.png"));
		} else {
			ImageIO.write(newImg, "png", new File(path + "/img.png"));
		}
		
	}

}