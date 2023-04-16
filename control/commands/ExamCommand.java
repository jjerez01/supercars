
package es.ucm.tp1.supercars.control.commands;

import es.ucm.tp1.supercars.logic.Game;

public class ExamCommand extends Command{
	
	private static final String NAME = "exam";

	private static final String DETAILS = "Exam [x]";

	private static final String SHORTCUT = "x";

	private static final String HELP = "new exam command";

	public ExamCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public boolean execute(Game game) {
		System.out.println("comando de examen!");;
		return true;
	}

}

