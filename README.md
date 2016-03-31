# Converting between File Formats

This is project show as you can use JaxB and Moxy libraries, to perform conversion between Json and XML formats. In this case that conversion is done making bind from Files's data to Java Objects. The methods that performs the read and write from fails are generics and you just need to have concern about making the correct composition in you data model.


# Reading Method 


```Java

	public static <T> T readFile(String path, T dto, FileType fileType) {
	    File file = new File(path);
	    FileInputStream fis = null;
	    JAXBContext jaxbContext = null;
	    T dataFile = null;
	
	    try {
	      jaxbContext = JAXBContext.newInstance(dto.getClass());
	      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
	      
	      if(fileType.getId().equals(fileType.JSON.getId())){
	        unmarshaller.setProperty("eclipselink.media-type", "application/json");
	      }
	      
	      fis = new FileInputStream(file);
	      InputSource is = new InputSource(fis);
	      is.setEncoding("UTF-8");
	      dataFile = (T) unmarshaller.unmarshal(is);
	    } catch (FileNotFoundException e) {
	      UtilLog.logError("Cannot Read File! \n", e);
	    } catch (JAXBException e) {
	      e.printStackTrace();
	    }
	
	    return dataFile;
	  }
  
```

# Using reading method

```Java

	GpxDTO gpx = FileDAO.readFile("./xml/data.gpx", new GpxDTO(), UtilEnums.FileType.XML);

```


# Writing Method

```Java

	public static <T> void writeFile(String path, T dto, FileType fileType) {
	    try {
	      File file = new File(path);
	      JAXBContext jaxbContext = JAXBContext.newInstance(dto.getClass());
	      Marshaller marshaller = jaxbContext.createMarshaller();
	      
	      if(fileType.getId().equals(fileType.JSON.getId())){
	        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
	        marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);
	      }
	      
	      // Set it to true if you need the JSON output to formatted
	      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	      marshaller.marshal(dto, file);
	      
	      // output pretty printed
	      marshaller.marshal(dto, System.out);
	    } catch (JAXBException e) {
	      e.printStackTrace();
	    }
	  }

```

# Using write method

```Java

	FileDAO.writeFile("./json/gpx.json", gpx, UtilEnums.FileType.JSON);

```
