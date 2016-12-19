# FileFilter
FileFilter is a simple library of file filtering and operation


## Basic usage
```java
Pipeline pipeline = new Pipeline();
PipelineRunner runner = new PipelineRunner(pipeline);

pipeline.put(new ChildFiles().option("recursive", true));
pipeline.put(new SelectExtention().option("txt"));
pipeline.put(new PrintList());

try {
    runner.run(new File("C:/test"));
} catch (Exception e) {
    e.printStackTrace();
}
```


## List of filters
### Selection
- SelectExtention
- SelectRegexName

### Exclusion
- ExcludeExtention

### Exploration
- ChildFiles

### Process
- CopyFiles
- PrintList
