package io.mosip.pmp.partner.util;

import java.util.List;

import io.mosip.pmp.authdevice.dto.SearchFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Optional Filters
 * 
 * @author Abhishek Kumar
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionalFilter {
	List<SearchFilter> filters;
}
