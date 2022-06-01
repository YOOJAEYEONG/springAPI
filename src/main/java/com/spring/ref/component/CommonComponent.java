package com.spring.ref.component;

import lombok.extern.slf4j.Slf4j;
import me.ccampo.uuid62.core.Base62;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;

@Slf4j
@Component
public class CommonComponent {


  public String createUUID(String uuidType) {

    log.debug("CommonComponent-debug");
    log.info("CommonComponent-info");
    log.trace("CommonComponent-trace");
    UUID uuid;
    String strUUID = null;

    ByteBuffer uuidBytes;

    try {
//			uuid = Generators.randomBasedGenerator().generate();
      uuid = Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate();

      uuidBytes = ByteBuffer.wrap(new byte[16]);
      uuidBytes.putLong(uuid.getMostSignificantBits());
      uuidBytes.putLong(uuid.getLeastSignificantBits());

      switch(uuidType) {
        case("V1"):
          uuid = Generators.timeBasedGenerator(EthernetAddress.fromInterface()).generate();
          strUUID = uuid.toString();
          break;
        case("V4"):
          strUUID = uuid.toString();
          break;
        case("BASE64"):
          strUUID = Base64.encodeBase64URLSafeString(uuidBytes.array());
          break;
        case("BASE62"):
          strUUID = Base62.INSTANCE.encode(uuidBytes.array());
          break;
        default:
          break;
      }
      return strUUID;
    } catch (Exception e) {
      // TODO: handle exception
      log.error(e.getMessage() , e);
      return null;
    }
  }


  public String currentTime() {
    SimpleDateFormat simpleDateFormat;

    try {
      simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

      return simpleDateFormat.format(new Date());
    } catch (Exception e) {
      // TODO: handle exception
      log.error(e.getMessage() , e);
      return null;
    }
  }
}
