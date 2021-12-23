package tr.gov.*****.*****essp*****.interceptor;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.gov.*****.*****essp*****.model.dto.EDSKullanici;
import tr.gov.*****.*****essp*****.model.entity.BaseEntity;
import tr.gov.*****.*****essp*****.model.entity.metamodel.BaseEntityMM;
import tr.gov.*****.*****essp*****.service.sam.SamUserService;

@Component
public class EntityInterceptor extends EmptyInterceptor {

  private static final long serialVersionUID = 1L;

  private @Autowired SamUserService samUserService;

  @Override
  public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

    Date currentDate = Calendar.getInstance().getTime();

    EDSKullanici kullanici = samUserService.getKullanici();

    if (entity instanceof BaseEntity) {
      for (int i = 0; i < propertyNames.length; i++) {
        if (BaseEntityMM.YRTM_ZAMAN.equals(propertyNames[i])) {
          state[i] = currentDate;
        }
        if (BaseEntityMM.YRTM_KULLANICI_ID.equals(propertyNames[i]) || BaseEntityMM.GUNC_KULLANICI_ID.equals(propertyNames[i])) {
          state[i] = kullanici.getSiraNo();
        }
      }
    }

    return true;

  }

  @Override
  public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {

    Date currentDate = Calendar.getInstance().getTime();

    EDSKullanici kullanici = samUserService.getKullanici();

    if (entity instanceof BaseEntity) {
      for (int i = 0; i < propertyNames.length; i++) {
        if (BaseEntityMM.GUNC_ZAMAN.equals(propertyNames[i])) {
          currentState[i] = currentDate;
        }
        if (BaseEntityMM.GUNC_KULLANICI_ID.equals(propertyNames[i])) {
          currentState[i] = kullanici.getSiraNo();
        }
      }
    }

    return true;

  }

}
