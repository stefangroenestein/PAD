/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAD.GUI;

import static PAD.main.Main.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author max
 */
public class Highscore {
     private final IntegerProperty id, highscore;
	private final StringProperty userName;
        
        public Highscore(Integer id, Integer highscore, String userName){
            
            this.id = new SimpleIntegerProperty(id);
            this.highscore = new SimpleIntegerProperty(highscore);
            this.userName = new SimpleStringProperty(userName);
        
        }

    public IntegerProperty getId() {
        return id;
    }
    
    	public void setId(Integer id) {
		this.id.set(id);
	}

    public IntegerProperty getHighscore() {
        return highscore;
    }

    	public void setHighscore(Integer highscore) {
		this.highscore.set(highscore);
	}
    public StringProperty getUserName() {
        return userName;
    }
    
    	public void setUserName(String userName) {
		 this.userName.set(userName);
	}

        	public  ObservableList<Highscore> getHighscoreData() {
		ObservableList<Highscore> highscoreData = FXCollections.observableArrayList();

		try {
			Statement statement = connection.createStatement();
			ResultSet highscore = statement.executeQuery(" SELECT userName, highscore.scoreFROM user JOIN highscore on user.ID = highscore.user_ID order by highscore.score desc ");

			while (highscore.next()) {
				highscoreData.add(new Highscore(
						highscore.getInt("id"),
						highscore.getInt("score"),
						highscore.getString("userName")));
	
			}
		} catch (SQLException ex) {
			System.err.println(ex);
		}

		return highscoreData;
	}

    public void getScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
