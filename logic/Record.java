package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.NonReadableChannelException;

import es.ucm.tp1.supercars.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.exceptions.InputOutputRecordException;

public class Record {
	

	private static Long recordTest = Long.MAX_VALUE;
	
	private static Long recordEasy = Long.MAX_VALUE;
	
	private static Long recordHard = Long.MAX_VALUE;
	
	private static Long recordAdvanced = Long.MAX_VALUE;
	
	private static Long theRecord;
	
	
	public static final String filename = "Record.txt";
	
	
	public static void loadRecord(Game game){
		try {
			theRecord = updateRecord(game);
			saveRecord(game);
		}
		catch (CommandExecuteException ce){
			System.out.println(ce.getMessage());
			game.forceFinish();
		}
	}
	
	public static Long updateRecord(Game game) throws InputOutputRecordException{
		Long ret = null;
		try(BufferedReader archivo = new BufferedReader(new FileReader(filename))){
			String a = archivo.readLine();
			while (a != null) {
				String divideString[] = a.split(":");
				if(divideString[0].equals("TEST") || divideString[0].equals("EASY") || divideString[0].equals("HARD") || divideString[0].equals("ADVANCED")) { 
					if(divideString[0].equals(game.getLevel().name())) {
						Long possibleNewRecord = Long.parseLong(divideString[1]);
						if (game.elapsedTime() < possibleNewRecord) {
							ret = game.elapsedTime();
						}
						else {
							ret = possibleNewRecord;
						}
						
					}
				}
				else {
					throw new InputOutputRecordException("could not detect EASY, HARD, ADVANCED OR TEST");
				}
				a = archivo.readLine();
			}
			return ret;
		}
		catch(IOException io){
			System.out.println("no file");
			throw new InputOutputRecordException(io);
			
		}
		catch(NumberFormatException ne) {
			System.out.println(ne.getMessage());
			throw new InputOutputRecordException("file with errors");
		}
		catch (InputOutputRecordException e) {
			throw (e);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new InputOutputRecordException("File with errors", ex);
		}
		
	}
	
	public static void saveRecord(Game game) throws CommandExecuteException {
		try (BufferedWriter archivo = new BufferedWriter(new FileWriter(filename))){
			if(game.getLevel().name() == "EASY") {
				archivo.write("TEST:" + recordTest + "\n" + "EASY:" + theRecord + "\n" +"HARD:" + recordHard + "\n" + "ADVANCED:" + recordAdvanced  );
			}
			
			if(game.getLevel().name() == "TEST") {
				archivo.write("TEST:" + theRecord + "\n" + "EASY:" + recordEasy + "\n" +"HARD:" + recordHard + "\n" + "ADVANCED:" + recordAdvanced  );
			}
			
			if(game.getLevel().name() == "HARD") {
				archivo.write("TEST:" + recordTest + "\n" + "EASY:" + recordEasy + "\n" +"HARD:" +  theRecord + "\n" + "ADVANCED:" + recordAdvanced  );
			}
			
			if(game.getLevel().name() == "ADVANCED") {
				archivo.write("TEST:" + recordTest + "\n" + "EASY:" + recordEasy + "\n" +"HARD:" +  recordHard + "\n" + "ADVANCED:" +  theRecord  );
			}
			
			
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			throw new CommandExecuteException("aaa",ioe);
		}
	}
}
