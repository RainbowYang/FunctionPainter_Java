package rainbow.inner.system.image;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * 此类用于在MainFrame上画出来自所有MyImage子类的image
 * 
 * @author Rainbow Yang
 * @version V1.4
 *
 */
@SuppressWarnings("serial")
public class FrameImages extends JPanel {

	private List<MyImage> list = new ArrayList<>();

	public FrameImages() {
	}
	
	public void add(MyImage i){
		list.add(i);
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (MyImage i : list) {
			g.drawImage(i.getImage(), 0, 0, null);
		}
	}
}
