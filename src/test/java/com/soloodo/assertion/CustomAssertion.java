package com.soloodo.assertion;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Lists;

import java.util.List;

public class CustomAssertion extends Assertion
{
    public List<String> assert_messages = Lists.newArrayList();

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand)
    {
        assert_messages.add("Assertion passed" + assertCommand.getMessage());
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex)
    {
        assert_messages.add("Assertion failed:" + assertCommand.getMessage());
    }

    public List<String> getAssertMessages()
    {
        return assert_messages;
    }
}
