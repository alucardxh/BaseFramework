package com.baseframework.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	public static void ImageCut(String srcPath, String targetPath) {
		try {
			BufferedImage image = ImageIO.read(new File(srcPath));
			BufferedImage newImage = image.getSubimage(20, 20, 100, 100);
			ImageIO.write(newImage, "png", new File(targetPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
