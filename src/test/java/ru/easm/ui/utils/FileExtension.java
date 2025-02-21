package ru.easm.ui.utils;

public enum FileExtension {
    JSON(".json", "text/plain"),
    PDF(".pdf", "application/pdf"),
    HTML(".html", "text/html"),
    TXT(".txt", "text/plain"),
    JPEG(".jpg", "image/jpeg");

    private final String format;
    private final String mimeType;

    FileExtension(final String format, final String mimeType) {
        this.format = format;
        this.mimeType = mimeType;
    }

    public String getFormat() {
        return format;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getFileName(final String fileName) {
        return fileName.concat(this.format);
    }
}