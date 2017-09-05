package javafeatures.io.test.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/**
 * @author panws
 * @since 2017-08-17
 */
public class FileLockingTest {

	public static void main(String[] args) throws IOException, InterruptedException {

		try (FileOutputStream out = new FileOutputStream("src/main/resources/io/output7.txt")) {

			FileLock fileLock = out.getChannel().tryLock();

			if (fileLock != null) {
				System.out.println("Locked file");
				Thread.currentThread().sleep(10000);
				fileLock.release();
				System.out.println("Unlocked file");
			}
		}
	}
}