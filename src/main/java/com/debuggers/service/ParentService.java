package com.debuggers.service;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.Parent;

import java.util.Optional;
import java.util.Set;

public interface ParentService extends Service<Parent, Long>{
    Optional<Parent> read(Long id);
}
