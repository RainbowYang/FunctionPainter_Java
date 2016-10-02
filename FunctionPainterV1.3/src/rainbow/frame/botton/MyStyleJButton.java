package rainbow.frame.botton;

import java.awt.Font;

import javax.swing.JButton;

/**
 * 由于所有按钮都采用了一样的设置，故写此类以减少重复。 本类提供默认的字体和大小，但也可以更改。
 * 
 * @author Rainbow_Yang
 * @version V1.3
 *
 */
public class MyStyleJButton extends JButton {
	private static final long serialVersionUID = 5091141873842870259L;

	private static Font f = new Font("微软雅黑", Font.BOLD, 30);

	public MyStyleJButton(String title) {
		super(title);
		this.setFont(f);
		this.setSize(140, 50);
	}

}
