package com.eclipssource.rap.draw.example;

import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class DrawGC extends AbstractEntryPoint {

  @SuppressWarnings("serial")
  @Override
  public void createContents( Composite parent ) {

    parent.setLayout( new FillLayout() );
    Canvas canvas = new Canvas( parent, SWT.NONE );

    canvas.addPaintListener( new PaintListener() {

      public void paintControl( PaintEvent event ) {
        // event.gc.setClipping(100,100,200, 200);
        drawCar( event.gc, 500, 200 );
        Transform transform = new Transform( event.display );
        transform.rotate( 20 );
        event.gc.setTransform( transform );
        drawCar( event.gc, 900, 200 );
        transform.identity();
        transform.dispose();

      }
    } );
  }

  private static void drawCar( GC gc, int x, int y ) {
    Device device = gc.getDevice();
    Color wingBackgroundColor = new Color( device, 73, 90, 254 );
    gc.setBackground( wingBackgroundColor );
    Path path = new Path( device );
    path.moveTo( x, y );
    path.lineTo( x - 190, y );
    path.lineTo( x - 230, y + 70 );
    path.lineTo( x - 330, y + 90 );
    path.lineTo( x - 330, y + 160 );
    path.lineTo( x, y + 160 );
    path.lineTo( x, y );
    path.close();
    gc.fillPath( path );
    gc.setLineWidth( 4 );
    gc.drawPath( path );
    path.dispose();
    gc.drawLine( x - 230, y + 70, x, y + 70 );
    gc.drawLine( x - 190, y, x - 190, y + 70 );
    gc.drawLine( x - 90, y, x - 90, y + 70 );

    Color circleColor = new Color( device, 0, 0, 0 );
    gc.setBackground( circleColor );
    gc.drawOval( x - 300, y + 125, 70, 70 );
    gc.fillOval( x - 300, y + 125, 70, 70 );
    gc.drawOval( x - 100, y + 125, 70, 70 );
    gc.fillOval( x - 100, y + 125, 70, 70 );
    circleColor.dispose();

  }

}