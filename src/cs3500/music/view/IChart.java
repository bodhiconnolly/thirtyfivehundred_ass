package cs3500.music.view;

import java.util.ArrayList;

/**
 * Created by matteoalampi on 11/30/16.
 */
public interface IChart {
  int numberOfBeats();

  int getMaxPitch();

  int getMinPitch();

  int getTempo();

  ArrayList<ArrayList<UnmodifiableNote>> getAllNotes();
}
