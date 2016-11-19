package cs3500.music.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test note class.
 */
public class NoteTest {
  Note note1;
  Note note2;
  AScale diatonicScale = new DiatonicScale();

  // Test the constructor
  @Test
  public void testConstructor() {
    // Test that sustains are properly added and all other fields are initialized properly
    note1 = new Note(4, 3, 2, 1, 0);
    note2 = new Note(4, 3, 2, 2, 0);
    assertEquals(1, note1.sustains.size());
    assertEquals(2, note2.sustains.size());
    assertEquals(4, note1.pitch);
    assertEquals(3, note1.baseInterval);
    assertEquals(2, note1.beat);
  }

  // Test note validation
  @Test
  public void testValidation() {
    note1 = new Note(4, 3, 2, 1, 0);
    note2 = new Note(4, 3, 2, 2, 0);
    assertEquals(4, note1.pitch);
    assertEquals(4, note2.pitch);
  }

  // Test invalid notes
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPitch() {
    note1 = new Note(200, 3, 2, 1, 0);
    note1.validNote(diatonicScale);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBaseInterval() {
    note1 = new Note(4, 20, 2, 1, 0);
    note1.validNote(diatonicScale);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidBeat() {
    note1 = new Note(4, 3, -1, 1, 0);
    note1.validNote(diatonicScale);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidDuration() {
    note1 = new Note(4, 3, 2, 0, 0);
    note1.validNote(diatonicScale);
  }
}