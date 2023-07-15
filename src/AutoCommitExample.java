import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class AutoCommitExample {
    public static void main(String[] args) throws IOException, GitAPIException {

//        UserTest userTest = new UserTest();

//        String encodedPassword = URLEncoder.encode(userTest.getPassword(), "UTF-8");

        try (Git git = Git.open(new File("D:\\auto-commit-test"))) {
            // Add your logic here ...
            RemoteAddCommand remoteAddCommand = git.remoteAdd();
            remoteAddCommand.setName("origin");
            try {
                remoteAddCommand.setUri(new
                        URIish("https://github.com/qkrmekem/auto-commit-test.git"));
                System.out.println("file Added");
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            git.add().addFilepattern(".").call();
            // you can add more settings here if needed
            remoteAddCommand.call();
            git.commit().setMessage( "auto-commit" ).call();

            // push to remote:
//            PushCommand pushCommand = git.push();
//            pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(userTest.getUsername().toString(), userTest.getPassword().toString()));
//            OAuth2CredentialsProvider credentialsProvider = new OAuth2CredentialsProvider(accessToken);
            // you can add more settings here if needed
//            pushCommand.call();

            try {
                System.out.println("여기까지 됨");
                git.push()
                        .setCredentialsProvider(new UsernamePasswordCredentialsProvider("test", "test"))
                        .setRemote("origin").add("main").call();
            } catch (TransportException e) {
                // Add your own logic here, for example:
//                System.out.println("Username or password incorrect.");
                System.out.println(e.toString());
            }

        }

    }
}