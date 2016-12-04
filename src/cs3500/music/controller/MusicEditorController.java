package cs3500.music.controller;

import cs3500.music.model.Adapter;
import cs3500.music.model.IChart;
import cs3500.music.model.IMusicEditorModel;
import cs3500.music.model.Track;
import cs3500.music.provider.IView;
import cs3500.music.provider.MidiViewModel;

/**
 * Created by matteoalampi on 12/4/16.
 */
public class MusicEditorController implements IMusicEditorController {
  MidiViewModel midiViewModel;
  IView view;

  public MusicEditorController(IMusicEditorModel iMusicEditorModel, IView view) {
    this.view = view;
    IChart chartTrack = new Adapter(iMusicEditorModel);
    this.midiViewModel = new MidiViewModel(chartTrack);
  }

  @Override
  public void begin() {
    this.view.run(midiViewModel);
  }
}
