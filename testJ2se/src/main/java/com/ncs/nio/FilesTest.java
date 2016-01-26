package com.ncs.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Path path = Paths.get("d:","fileChannel.txt");
		Files.copy(path, new FileOutputStream("d:/copyto.java"));
		System.out.println(Files.isHidden(path));
		System.out.println(Files.readAllLines(path, Charset.defaultCharset()));
		List<String> content = new ArrayList<String>();
		content.add("line");
		Files.write(path, content,Charset.defaultCharset());
		
		//遍历文件及子目录
		path = Paths.get("d:","guangping's life");
		Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println("visit file..."+file.getFileName());
				if(file.getFileName().endsWith("Unit 10.pdf")){
					System.out.println("find file");
					return FileVisitResult.TERMINATE;
				}
				return FileVisitResult.CONTINUE;
			}
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println("start visit file..."+dir.getFileName());
				return FileVisitResult.CONTINUE;
			}
		});
		
		//查看文件属性
		BasicFileAttributeView bfw = Files.getFileAttributeView(path, BasicFileAttributeView.class );
		System.out.println(bfw.readAttributes().creationTime());
		System.out.println(bfw.readAttributes().size());
		
		//WatchService监控文件变化
		path = Paths.get("d:","Coding");
		WatchService ws = FileSystems.getDefault().newWatchService();
		path.register(ws, StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE);
		while(true){
			try {
				WatchKey wk = ws.take();
				List<WatchEvent<?>> wes =  wk.pollEvents();
				for(WatchEvent<?> we : wes){
					WatchEvent.Kind<?> kind = we.kind();
					System.out.println(we.context()+" happened "+kind);
				}
				boolean valid = wk.reset();
				if(!valid){
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
