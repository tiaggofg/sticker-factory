package factory.classification;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;

public class Rating {

	private Classification classification;
	private BufferedImage stars = new BufferedImage(500, 45, BufferedImage.TRANSLUCENT);

	public Rating(Double value) throws IOException {
		create(value);
	}

	public Classification getClassification() {
		return classification;
	}

	public BufferedImage getStars() {
		return stars;
	}

	public void create(Double value) throws IOException {

		try {

			var path = (Path.of("").toAbsolutePath().toString()).split("/bin");
			BufferedImage starFill = ImageIO.read(new File(path[0] + "/resource/img/star.png"));
			Graphics2D graphics = stars.createGraphics();

			int rating = Integer.parseInt(String.format("%.0f", value));

			int n = 0;
			if (rating >= 0 && rating < 3) {
				classification = Classification.AWFUL;
				for (int i = 0; i < rating; i++) {
					graphics.drawImage(starFill, n, 0, null);
					n += 50;
				}
				stars = stars.getSubimage(0, 0, n, stars.getHeight());
			} else if (rating >= 3 && rating < 6) {
				classification = Classification.MEDIOCRE;
				for (int i = 0; i < rating; i++) {
					graphics.drawImage(starFill, n, 0, null);
					n += 50;
				}
				stars = stars.getSubimage(0, 0, n, stars.getHeight());
			} else if (rating >= 6 && rating < 8) {
				classification = Classification.GOOD;
				for (int i = 0; i < rating; i++) {
					graphics.drawImage(starFill, n, 0, null);
					n += 50;
				}
				stars = stars.getSubimage(0, 0, n, stars.getHeight());
			} else {
				classification = Classification.SUPERB;
				for (int i = 0; i < rating; i++) {
					graphics.drawImage(starFill, n, 0, null);
					n += 50;
				}
				stars = stars.getSubimage(0, 0, n, stars.getHeight());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
