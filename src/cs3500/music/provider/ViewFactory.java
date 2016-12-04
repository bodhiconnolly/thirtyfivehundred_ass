package cs3500.music.provider;

/**
 * Factory class for {@link IView}.
 */
public class ViewFactory {
  /**
   * Factory method for IView.
   *
   * @param type A string with the name of the type of provider to construct.
   * @return The constructed IView.
   * @throws IllegalArgumentException If there is no type of provider with the given name.
   */
  public static IView makeView(String type) throws IllegalArgumentException {
    switch (type.toLowerCase()) {
      case "console":
        return new ConsoleView();
      case "visual":
        return new GuiViewImpl();
      case "midi":
        return new MidiView();
      case "audiovisual":
        return new AudioVisualView();
      default:
        throw new IllegalArgumentException("No such provider.");
    }
  }
}
