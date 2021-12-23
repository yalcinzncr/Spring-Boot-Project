package tr.gov.*****.*****essp*****.service.sam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import tr.gov.*****.*****essp*****.constant.SamUserAttributes;
import tr.gov.*****.*****essp*****.exception.ApiException;
import tr.gov.*****.*****essp*****.model.dto.EDSKullanici;
import tr.gov.*****.security.sam.SAMUser;
import tr.gov.*****.security.sam.SAMUtil;

@Component
public class SamUserServiceImpl implements SamUserService, Serializable {

  private static final long serialVersionUID = 1L;

  @Override
  public EDSKullanici getKullanici() {

    SAMUser samUser = SAMUtil.getSAMUser();

    if (Objects.isNull(samUser)) {
      throw new ApiException("Kullanıcı bulunamadı!");
    }

    Map<String, Set<String>> attributesMap = samUser.getAttributes();

    if (Objects.isNull(attributesMap) || attributesMap.isEmpty()) {
      throw new ApiException("Kullanıcı bilgileri bulunamadı!");
    }

    Collection<String> roller = samUser.getRoles();

    if (Objects.isNull(roller) || roller.isEmpty()) {
      throw new ApiException("Kullanıcı rolleri bulunamadı!");
    }

    EDSKullanici bindedUser = new EDSKullanici();

    bindedUser.setKullaniciKodu(samUser.getUsername());

    bindFromAttributesMap(bindedUser, attributesMap);

    if (Objects.isNull(bindedUser.getSiraNo())) {
      throw new ApiException("Kullanıcı sıra numarası bulunamadı!");
    }

    if (StringUtils.isBlank(bindedUser.getKullaniciKodu())) {
      throw new ApiException("Kullanıcı kodu bulunamadı!");
    }

    Iterator<String> rollerIterator = roller.iterator();

    while (rollerIterator.hasNext()) {

      String rol = rollerIterator.next();

      if (StringUtils.isBlank(rol)) {
        rollerIterator.remove();
      }

    }

    bindedUser.setRoller(new ArrayList<>(roller));

    return bindedUser;

  }

  private void bindFromAttributesMap(EDSKullanici user, Map<String, Set<String>> attributes) {

    Set<?> attributeValue = null;

    for (Entry<String, Set<String>> attribute : attributes.entrySet()) {

      if (Objects.isNull(attribute) || Objects.isNull(attribute.getKey()) || Objects.isNull(attribute.getValue())) {
        continue;
      }

      attributeValue = attribute.getValue();

      String attributeKey = attribute.getKey();

      String value = (String) attributeValue.iterator().next();

      if (attributeKey.equalsIgnoreCase(SamUserAttributes.AD_SOYAD)) {
        user.setAdSoyad(value);
      } else if (attributeKey.equalsIgnoreCase(SamUserAttributes.KULLANICI_KODU)) {
        user.setKullaniciKodu(value);
      } else if (attributeKey.equalsIgnoreCase(SamUserAttributes.SICIL)) {
        user.setSicil(value);
      } else if (attributeKey.equalsIgnoreCase(SamUserAttributes.MUDURLUK)) {
        user.setMudurluk(value);
      } else if (attributeKey.equalsIgnoreCase(SamUserAttributes.UNVAN)) {
        user.setUnvan(value);
      } else if (attributeKey.equalsIgnoreCase(SamUserAttributes.SIRA_NO)) {

        Integer parsedSiraNo = null;

        try {
          parsedSiraNo = Integer.decode(value);
        } catch (NumberFormatException ignored) {
          //
        }

        user.setSiraNo(parsedSiraNo);

      }

    }

  }

}
