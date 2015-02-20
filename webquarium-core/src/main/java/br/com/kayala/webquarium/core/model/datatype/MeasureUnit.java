/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kayala.webquarium.core.model.datatype;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author kayala
 */
public interface MeasureUnit extends Serializable {

	BigDecimal getRawValue();
}
