package ma.oujda.ump.ensao.autogo;

public class AutoToArduino {

	private char[] ch;
	private Movement mv;

	public AutoToArduino() {
		mv = new Movement();
	}

	public void sendToArduino() throws InterruptedException {

		ch = AStarExecute.commandes.toCharArray();

		for (int i = 0; i < ch.length; i++) {

			if (ch[i] == '8') {
				mv.goForward();
			} else if (ch[i] == '4') {
				mv.goLeft();
			} else if (ch[i] == '6') {
				mv.goRight();
			}
		}
	}
}
