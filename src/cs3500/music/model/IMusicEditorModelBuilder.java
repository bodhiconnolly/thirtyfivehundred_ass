package cs3500.music.model;

/**
 * Class for building a IMusicEditorModel. Provides one static method for building.
 */
public class IMusicEditorModelBuilder {
  public static IMusicEditorModel build(MusicEditorType met, AScale scale, int measures) {
    switch (met) {
      case TRACK:
        return new Track(scale, measures);
      default:
        throw new IllegalArgumentException("Invalid cs3500.music.model type.");
    }
  }
}
