package gui.deterministic;

import gui.editor.StateTool;
import gui.regular.FSAToREController;
import gui.viewer.AutomatonDrawer;
import gui.viewer.AutomatonPane;

import java.awt.event.MouseEvent;

import automata.State;

/**
 * Aids in creating new trap state 
 * @author Kyung Min (Jason) Lee
 *
 */
public class TrapStateTool extends StateTool {


	/** The state that was created. */
	private State myTrapState = null;

	/** The controller object. */
	private AddTrapStateController myController;
	
	/**
	 * Instantiates a new trap state tool.
	 * 
	 * @param view
	 *            the view that the automaton is drawn in
	 * @param drawer
	 *            the automaton drawer for the view
	 * @param controller
	 *            the controller object we report to
	 */
	public TrapStateTool(AutomatonPane view, AutomatonDrawer drawer,
			AddTrapStateController controller) {
		super(view, drawer);
		myController = controller;
	}

	/**
	 * When the user clicks, one creates a state.
	 * 
	 * @param event
	 *            the mouse event
	 */
	public void mousePressed(MouseEvent event) {
		if ((myTrapState = myController.stateCreate(event.getPoint())) == null)
			return;
		getView().repaint();
	}

	/**
	 * When the user drags, one moves the created state.
	 * 
	 * @param event
	 *            the mouse event
	 */
	public void mouseDragged(MouseEvent event) {
		if (myTrapState == null)
			return;
		myTrapState.setPoint(event.getPoint());
		getView().repaint();
	}
}