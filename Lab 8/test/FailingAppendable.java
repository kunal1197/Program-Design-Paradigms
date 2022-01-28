import java.io.IOException;

/**
 * A mock to simulate a failure to write to the Appendable.
 */
public class FailingAppendable implements Appendable {

  /**
   * Appendable.append(CharSequence csq, int start, int end)
   *
   * @throws IOException fail.
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Fail!");
  }

  /**
   * Appendable.append(CharSequence csq, int start, int end)
   *
   * @throws IOException fail.
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Fail!");
  }

  /**
   * Appendable.append(char c)
   *
   * @throws IOException fail.
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Fail!");
  }
}
