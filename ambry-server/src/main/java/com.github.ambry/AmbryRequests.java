package com.github.ambry;

import java.io.DataInputStream;
import com.ambry.shared.PutRequest;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: srsubram
 * Date: 10/15/13
 * Time: 1:22 AM
 * To change this template use File | Settings | File Templates.
 */

public class AmbryRequests {
  private final RequestResponseChannel requestChannel;
  private static final short PutRequestType = 1;

  public AmbryRequests(RequestResponseChannel requestChannel) {
    this.requestChannel = requestChannel;
  }

  public void handleRequests(Request request) {
    try {
      // log
      DataInputStream stream = (DataInputStream)request.getInputStream();
      switch (stream.readShort()) {
        case PutRequestType:
          handlePutRequest(request);
          break;
        default: // throw exception
      }
    } catch (Exception e) {
      // log and measure time
    }
  }

  private void handlePutRequest(Request request) throws IOException {
    PutRequest putRequest = PutRequest.readFrom((DataInputStream)request.getInputStream());
    // need store manager to get store

    // issue append

    // create put response

    // send to request channel
  }
}