package cs3500.music.model;

/**
 * Class for building a IMusicEditorModel.
 */
public class IMusicEditorModelBuilder {
  /**
   * Generates a new music model.
   * @param met
   * @param scale
   * @param measures
   * @return
   */
  public static IMusicEditorModel build(MusicEditorType met, AScale scale, int measures) {
    switch (met) {
      case TRACK:
        return new Track(scale, measures);
      default:
        throw new IllegalArgumentException("Invalid cs3500.music.model type.");
    }
  }
}
