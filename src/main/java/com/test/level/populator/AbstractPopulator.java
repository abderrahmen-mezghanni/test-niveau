package com.test.level.populator;

abstract public class AbstractPopulator<E,M>  {

	protected abstract M toModel(E entity);
	protected abstract E toEntity(M model);
}
