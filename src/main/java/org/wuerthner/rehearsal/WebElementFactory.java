package org.wuerthner.rehearsal;

import java.io.File;
import java.util.Optional;

import jakarta.ejb.Stateless;

import org.wuerthner.rehearsalmodel.RehearsalFactory;
import org.wuerthner.sport.api.Executor;
import org.wuerthner.sport.api.ModelElementFactory;

@Stateless
public class WebElementFactory extends RehearsalFactory implements ModelElementFactory {
	@Override
	public Optional<Executor<File>> getPdfViewerExecutor() { return Optional.empty(); }
}
