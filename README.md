# Poniżej znajduje się opis zadania rekrutacyjnego: 
#### Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu i samodzielne zaimplementowanie metod findFolderByName, findFolderBySize, count w klasie FolderCabinet - najchętniej unikając powielania kodu i umieszczając całą logikę w klasie FolderCabinet. 
#### Z uwzględnieniem w analizie i implementacji interfejsu MultiFolder!
```
interface Cabinet {
    // zwraca dowolny element o podanej nazwie
    Optional<Folder>
    findFolderByName(String name);

    // zwraca wszystkie foldery podanego rozmiaru SMALL/MEDIUM/LARGE
    List<Folder> findFoldersBySize(String size);

    //zwraca liczbę wszystkich obiektów tworzących strukturę
    int count();
}
```
```
public class FileCabinet implements Cabinet {
    private List<Folder> folders;
}
```

interface Folder {
    String getName();
    String getSize();
}
```
```
interface MultiFolder extends Folder {
    List<Folder> getFolders();
}
```
