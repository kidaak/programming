/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author hoangnv
 */
@Component
public class CDPlayer implements MediaPlayer {

	private CompactDisc compactDisc;

	public CDPlayer() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.compactDisc = cd;
	}

	@Override
	public void play() {
		compactDisc.play();
	}

	public CompactDisc getCompactDisc() {
		return compactDisc;
	}

	public void setCompactDisc(CompactDisc compactDisc) {
		this.compactDisc = compactDisc;
	}

}
