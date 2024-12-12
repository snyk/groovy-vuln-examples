import java.io.File;
import groovy.io.FileType

def tainted_input = new URL("https://example.com").getText()
def folder = new File(tainted_input);

folder.eachFile({ f -> 
    // PT VULNERABILITY HERE
    f.append('hello');
})

folder.eachFileRecurse(FileType.FILES) { f ->
    // PT VULNERABILITY HERE
    f.append('hello');
}

folder.eachFileMatch(FileType.FILES, 'example') { f ->
    // PT VULNERABILITY HERE
    f.append('hello');
}
