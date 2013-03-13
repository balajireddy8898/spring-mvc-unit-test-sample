### Spring MVC Unit Test Sample

#### Overview
Fluent api, enable testing of controller as `controller`, not just as a method (think request mapping).

See the full presentation from springsource [here](https://www.youtube.com/watch?v=K6x8LE7Qd1Q "Webinar: Testing Web Applications with Spring 3.2").

Get the sample codes [here](https://github.com/andirdju/spring-mvc-unit-test-sample "GitHub Repo").

#### Details
##### Unit Test (standalone) vs Integration Test
I would say this is a unit test because we will mock the `collborators`, although we also have the option to not mock the `collaborators` thus doing something like an integration test.

In the spirit of unit-testing, I personally prefer to do standalone testing on the controller, by mocking the `collaborators` and testing one controller at a time.

##### DispatcherServlet runtime (so we can test request mapping)
It will handle the creation of `DispatcherServlet` runtime for the test, so we can also test the mvc wiring, not just the inner workings of the methods.

We won't call the controller methods directly. Instead we will create a mock request and pass it to the provided [mvc test infrastructure](http://static.springsource.org/spring/docs/3.2.x/javadoc-api/org/springframework/test/web/servlet/MockMvc.html "MockMvc"). 

##### MockMvc and other usefull mocks
Classes in `org.springframework.test.web.servlet.*`
Check for yourself [here](http://static.springsource.org/spring/docs/3.2.x/javadoc-api/org/springframework/test/web/servlet/package-summary.html "Contains server-side support for testing Spring MVC applications").


##### Assertions
We have several options for asserting, either the manually asserting `response` and/or the `ModelAndView` object, or using the springframework api.

For asserting the result manually, I would prefer asserting the `ModelAndView`, instead of the `response` object.

I think asserting the response object would only be realistic if our controllers are json/xml web service endpoints. I don't feel like asserting html markup...

Asserting the `response` rendering result is also not supported if the rendering technology is `jsp` (not running in a servlet container). Freemarker, Velocity, Xslt, etc, is supported. Another reason not to use `jsp`?

##### Fluent api
Api that looks like a `builder` pattern.

##### Sample from springsource presentation and ref docs
Creating Standalone Unit Test

    ...
    import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
    ...
    @InjectMocks
    private HomeController homeController;
    ...
    @Mock
    private TimeService timeService;
    ...
    @Before
    public void before() {
        ...
        this.mockMvc = standaloneSetup(this.homeController).build();
    }
    ...

Fluent Api

    ...
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    ...
    @Test
    public void homeTest() throws Exception {
        // note: we don't call the controller method manually here!
        this.mockMvc.perform(get(HomeControllerTest.PATH)).andExpect(
            status().isOk());
        ...
    }
    ...

Access to underlying request, response, ModelAndView object

    ...
    import static org.springframework.test.web.ModelAndViewAssert.assertModelAttributeValue;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    ...
    @Test
    public void homeAssertMavTest() throws Exception {
        // note: we don't call the controller method manually here!
        MvcResult mvcResult = this.mockMvc.perform(get(HomeControllerTest.PATH)).andReturn();
        ...
        ModelAndView modelAndView = mvcResult.getModelAndView();
        MockHttpServletRequest request = mvcResult.getRequest();
        MockHttpServletResponse response = mvcResult.getResponse();
        ...    
        // assertions
        ...
        // spring mvc ModelAndView specific assertion
        assertModelAttributeValue(modelAndView, HomeControllerTest.SERVER_TIME,
            HomeControllerTest.EN_RESULT);
        ...
    }
    ...
