package sample;

public class PDFPreset implements IPreset{
    @Override
    public String SetExtension() {
        return "*.pdf";
    }

    @Override
    public String SetExtensionName() {
        return "PDF Files";
    }

    @Override
    public void SetViewerSettings() {

    }
}
