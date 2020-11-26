/*
 * package io.mosip.pmp.common.test.helper;
 * 
 * import java.util.Arrays;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import io.mosip.pmp.common.dto.Pagination; import
 * io.mosip.pmp.common.dto.SearchDto; import
 * io.mosip.pmp.common.dto.SearchFilter; import
 * io.mosip.pmp.common.dto.SearchSort; import
 * io.mosip.pmp.common.entity.Partner; import
 * io.mosip.pmp.common.helper.SearchHelper;
 * 
 * 
 * @SpringBootTest
 * 
 * @RunWith(SpringRunner.class) public class SearchHelperTest {
 * 
 * @Autowired SearchHelper searchHelper;
 * 
 * private SearchFilter filter; private SearchSort sort; private Pagination
 * page;
 * 
 * @Before public void setup() { filter = new SearchFilter();
 * filter.setColumnName("name"); filter.setType("equals");
 * filter.setValue("Aujas Networks"); sort = new SearchSort();
 * sort.setSortField("name"); sort.setSortType("asc"); page = new Pagination();
 * page.setPageStart(0); page.setPageFetch(1);
 * 
 * 
 * }
 * 
 * @Test public void filterEntityTest() { SearchDto searchDto = new
 * SearchDto(Arrays.asList(filter), Arrays.asList(sort), page);
 * searchHelper.filterEntity(Partner.class, searchDto); } }
 */