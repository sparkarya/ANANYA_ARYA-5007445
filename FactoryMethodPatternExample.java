interface Document {
    void create();
}

class WordDocument implements Document {
    public void create() {
        System.out.println("Creating Word Document");
    }
}

class PdfDocument implements Document {
    public void create() {
        System.out.println("Creating PDF Document");
    }
}

class ExcelDocument implements Document {
    public void create() {
        System.out.println("Creating Excel Document");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory factory = new WordDocumentFactory();
        Document doc = factory.createDocument();
        doc.create();
    }
}
