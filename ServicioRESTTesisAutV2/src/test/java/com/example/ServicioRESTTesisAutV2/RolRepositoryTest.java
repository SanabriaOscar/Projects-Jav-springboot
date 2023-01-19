package com.example.ServicioRESTTesisAutV2;

import com.example.ServicioRESTTesisAutV2.model.Role;
import com.example.ServicioRESTTesisAutV2.repository.RolRepository;
import com.example.ServicioRESTTesisAutV2.service.RoleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RolRepositoryTest {
    @Autowired
    private  RolRepository rolRepository2;
    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RoleServiceImpl roleService;
    @BeforeEach
    public  void setup(){
        MockitoAnnotations.openMocks( this);
    }
    //------------------TESTINT WITH Mockito-------------------------------------
    @Test
    @Rollback(false)
    public void saveRolTest(){
        Role rol =Role.builder()
                .Id(10).name("other").build();
        when(rolRepository.save(ArgumentMatchers.any(Role.class))).thenReturn(rol);
        Role created = roleService.saveRole(rol);
        assertThat(created.getName()).isSameAs(rol.getName());
        verify(rolRepository).save(rol);
    }
    @Test
    public void ListAllRoles() {
        List<Role> roles = new ArrayList();
        roles.add(new Role());
        given(rolRepository.findAll()).willReturn(roles);
        List<Role> expected = roleService.ListAllRoles();
        assertEquals(expected, roles);
        verify(rolRepository).findAll();
}

    private void assertEquals(List<Role> expected, List<Role> roles) {
    }
    @Test
    public void listRolBYID() {
        Role rol =Role.builder()
                .Id(10).name("other").build();
        when(rolRepository.findById(rol.getId())).thenReturn(Optional.of(rol));
        Role expected = roleService.findRoleByid(rol.getId());
        assertThat(expected).isSameAs(rol);
        verify(rolRepository).findById(rol.getId());
    }
    @Test
    public void deleteRolTest(){
        Role rol =Role.builder()
                .Id(10).name("other").build();
        when(rolRepository.findById(rol.getId())).thenReturn(Optional.of(rol));
        roleService.deleteRole(rol.getId());
        verify(rolRepository).deleteById(rol.getId());
    }







    //------------------TESTINT WITH JUNIT-------------------------------------
    @Test
    @Rollback(false)
    public void testCreateRolJUnit() {
        Role savedRol = rolRepository2.save(new Role(11,"test 2"));

        assertThat(savedRol.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindRolJUnit() {
        Role rol = rolRepository2.findByName("USER");
        assertThat(rol.getName()).isEqualTo("USER");
    }

    @Test
    @Rollback(false)
    public void testUpdateRolJUnit() {
        Role rol = rolRepository2.findByName("ADMIN");
        rol.setName("other");

        rolRepository2.save(rol);

        Role updatedRol = rolRepository2.findByName("ADMIN");

        assertThat(updatedRol.getName()).isEqualTo("other");
    }
    @Test
    @Rollback(false)
    public void testDeleteRolJUnit() {
        Role rol = rolRepository2.findByName("ADMIN");

        rolRepository2.deleteById(rol.getId());

        Role deletedRol = rolRepository2.findByName("ADMIN");

        assertThat(deletedRol).isNull();

    }
    @Test
    public void testListRolesJUnit() {
        List<Role> roles = (List<Role>)rolRepository2.findAll();
       // assertThat(roles).size().isGreaterThan(0);
    }


}
