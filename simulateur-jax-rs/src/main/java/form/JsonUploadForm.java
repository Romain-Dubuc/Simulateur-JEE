package form;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class JsonUploadForm {
	
	private byte[] data;
	
	public byte[] getData() {
        return data;
    }
	
	@FormParam("file")
    @PartType("application/octet-stream")
    public void setFileData(final byte[] filedata) {
        this.data = filedata;
    }
	
	public JsonUploadForm() {}

}
