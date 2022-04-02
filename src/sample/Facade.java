package sample;

public class Facade {
    public String extension;
    public String extensionName;
    public String kind;

    public Facade(String kind) {
        this.kind = kind;
        switch (kind) {
            case "PDF":
                this.extension = new PDFPreset().SetExtension();
                this.extensionName = new PDFPreset().SetExtensionName();
                break;
            case "Image":
                this.extension = new ImgPreset().SetExtension();
                this.extensionName = new ImgPreset().SetExtensionName();
                break;
            case "Blanco":
                this.extension = new BlancoPreset().SetExtension();
                this.extensionName = new BlancoPreset().SetExtensionName();
                break;
            default:
                this.extension = null;
                this.extensionName = null;
                break;
        }
    }

}
