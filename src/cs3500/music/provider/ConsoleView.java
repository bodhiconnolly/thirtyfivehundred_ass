package cs3500.music.provider;

import java.io.IOException;

import cs3500.music.model.UnmodifiableNote;

/**
 * A ConsoleView is an implementation of {@link IView} that displays a song in a text format.
 */
public class ConsoleView implements IView {
  private Appendable out;

  /**
   * Default constructor for ConsoleView, takes input and output from System.in and System.out,
   * respectively.
   */
  public ConsoleView() {
    this.out = System.out;
  }

  public ConsoleView(Appendable out) {
    this.out = out;
  }

  @Override
  public void run(MidiViewModel viewModel) {
    try {
      if (viewModel.getNumberOfBeats() > 0) {
        int beatAmountLength = Integer.toString(viewModel.getNumberOfBeats()).length();

        String beatAmountFormat = "%" + beatAmountLength + "d";

        // The spaces before the name of the pitches
        for (int i = 0; i < beatAmountLength; i += 1) {
          this.out.append(" ");
        }

        int minPitch = viewModel.getMinPitch();
        int maxPitch = viewModel.getMaxPitch();

        // The names of the pitches
        for (int i = minPitch; i <= maxPitch; i += 1) {
          out.append(String.format(" %3s ", MidiViewModel.pitchToString(i)));
        }

        // A new line
        this.out.append('\n');

        int currentBeat = 0;

        // All of the beats
        for (int i = 0; i < viewModel.getNumberOfBeats(); i += 1) {
          // The number of this beat
          this.out.append(String.format(beatAmountFormat, currentBeat));

          int currentPitch = minPitch;
          // The notes in the beat
          while (currentPitch <= maxPitch) {
            String topNote = "     ";
            for (UnmodifiableNote n : viewModel.getNotesAtBeat(i)) {
              if (n.compareTo(currentPitch) == 0) {
                topNote = n.asString();
              }
            }
            // The note
            out.append(topNote);
            currentPitch += 1;
          }
          // The new line
          this.out.append('\n');
          currentBeat += 1;
        }
      }
    } catch (IOException e) {
      System.out.print(e.toString());
    }
  }
}
