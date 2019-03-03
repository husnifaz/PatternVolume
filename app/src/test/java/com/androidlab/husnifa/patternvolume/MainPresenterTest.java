package com.androidlab.husnifa.patternvolume;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
@Mock
private MainPresenter presenter;
private MainView view;

    @Before
    public void setUp() throws Exception {
        view = mock(MainView.class);
        presenter = new MainPresenter(view);
    }

    @Test
    public void testVolumeWithIntegerInput() throws Exception {
        double volume = presenter.volume(3, 5, 2);
        assertEquals(30, volume, 0.0001);
    }

    @Test
    public void testVolumeWithDoubleInput() throws Exception {
        double volume = presenter.volume(2.3, 8.1, 2.9);
        assertEquals(54.026999999999994, volume, 0.0001);
    }
}