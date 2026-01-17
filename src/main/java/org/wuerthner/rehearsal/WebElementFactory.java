package org.wuerthner.rehearsal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import jakarta.inject.Inject;
import org.wuerthner.rehearsalmodel.RehearsalFactory;
import org.wuerthner.sport.api.ActionProvider;
import org.wuerthner.sport.api.Executor;
import org.wuerthner.sport.api.ModelElementFactory;
import org.wuerthner.sport.persistence.dao.GenericDao;

@Stateless
public class WebElementFactory extends RehearsalFactory implements ModelElementFactory {
    @Inject
    public GenericDao genericDao;

	@Override
	public Optional<Executor<File>> getPdfViewerExecutor() { return Optional.empty(); }

    @Override
    public Map<String,String> getUserMap() {
        if (genericDao!=null) {
            return genericDao.getUserMap();
        }
        return new HashMap<>();
    }
}
