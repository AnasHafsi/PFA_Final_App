package ma.oujda.ump.ensao.autogo;

public class ManToArduino {

	private Movement mv;

	public ManToArduino() {
		mv = new Movement();
	}

	public void sendToArduino(char ch) throws InterruptedException {

		if (ch == '8') // forward 011
		{
			mv.goForward();
		} else if (ch == '4') // left 100
		{
			mv.goLeft();
		} else if (ch == '6') // right 001
		{
			mv.goRight();
		} else if (ch == '2') // backward 110
		{
			mv.goBack();
		} else if (ch == '5') // stop 000
		{
			mv.stop();
		}
	}
}
