// $Id: UploadInputModule.java,v 1.3 2008-06-17 14:09:50 fbatard Exp $
// Author: Damien LEROY.
// (c) COPYRIGHT MIT, ERCIM ant Keio, 2006.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.unicorn.input;

import java.io.IOException;
import java.io.InputStream;

import org.w3c.unicorn.contract.EnumInputMethod;

/**
 * Interface for the UploadInputModule
 * @author Damien LEROY 
 */
public interface UploadInputModule extends InputModule {

	public final EnumInputMethod aEnumInputMethod = EnumInputMethod.UPLOAD;

	public String getFileName();

	public InputStream getInputStream() throws IOException;

}
