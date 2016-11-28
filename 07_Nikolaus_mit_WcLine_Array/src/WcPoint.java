
public class WcPoint {

	private double x;
	private double y;

	public static int maxPixelX;
	public static int maxPixelY;

	public WcPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public int getPixelX() {
		int truepixel = (int) (maxPixelX * x);
		return truepixel;

	}

	public int getPixelY() {
		int truepixel = (int) (maxPixelY * y);
		return truepixel;

	}

}
