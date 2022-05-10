package com.mapbox.maps

import androidx.annotation.WorkerThread
import com.mapbox.bindgen.Expected
import com.mapbox.bindgen.None
import com.mapbox.bindgen.Value
import com.mapbox.common.Cancelable
import com.mapbox.geojson.Feature
import com.mapbox.geojson.Geometry
import com.mapbox.geojson.Point
import com.mapbox.maps.exception.WorkerThreadException
import java.util.*

internal class NativeMapImpl(private val map: MapInterface) :
  MapInterface, StyleManagerInterface, ObservableInterface {

  private val threadChecker = ThreadChecker()

  @WorkerThread
  override fun destroyRenderer() {
    map.destroyRenderer()
  }

  @WorkerThread
  override fun createRenderer() {
    map.createRenderer()
  }

  @WorkerThread
  override fun render() {
    map.render()
  }

  @WorkerThread
  override fun setSize(size: Size) {
    map.size = size
  }

  @WorkerThread
  override fun getSize(): Size {
    return map.size
  }

  override fun setCamera(cameraOptions: CameraOptions) {
    checkThread()
    map.setCamera(cameraOptions)
  }

  override fun getCameraState(): CameraState {
    checkThread()
    return map.cameraState
  }

  override fun dragStart(point: ScreenCoordinate) {
    checkThread()
    map.dragStart(point)
  }

  override fun dragEnd() {
    checkThread()
    map.dragEnd()
  }

  override fun getDragCameraOptions(
    fromPoint: ScreenCoordinate,
    toPoint: ScreenCoordinate
  ): CameraOptions {
    checkThread()
    return map.getDragCameraOptions(fromPoint, toPoint)
  }

  override fun coordinatesForPixels(pixels: MutableList<ScreenCoordinate>): MutableList<Point> {
    checkThread()
    return map.coordinatesForPixels(pixels)
  }

  override fun cameraForCoordinateBounds(
    coordinateBounds: CoordinateBounds,
    edgeInsets: EdgeInsets,
    zoom: Double?,
    pitch: Double?
  ): CameraOptions {
    checkThread()
    return map.cameraForCoordinateBounds(coordinateBounds, edgeInsets, zoom, pitch)
  }

  override fun setUserAnimationInProgress(inProgress: Boolean) {
    checkThread()
    map.isUserAnimationInProgress = inProgress
  }

  override fun invalidateStyleCustomGeometrySourceRegion(
    sourceId: String,
    coordinateBounds: CoordinateBounds
  ): Expected<String, None> {
    checkThread()
    return map.invalidateStyleCustomGeometrySourceRegion(sourceId, coordinateBounds)
  }

  override fun setStyleTerrain(properties: Value): Expected<String, None> {
    checkThread()
    return map.setStyleTerrain(properties)
  }

  override fun getStyleTerrainProperty(property: String): StylePropertyValue {
    checkThread()
    return map.getStyleTerrainProperty(property)
  }

  override fun setStyleTerrainProperty(property: String, value: Value): Expected<String, None> {
    checkThread()
    return map.setStyleTerrainProperty(property, value)
  }

  override fun setStyleProjection(properties: Value): Expected<String, None> {
    checkThread()
    return map.setStyleProjection(properties)
  }

  override fun getStyleProjectionProperty(property: String): StylePropertyValue {
    checkThread()
    return map.getStyleProjectionProperty(property)
  }

  override fun setStyleProjectionProperty(property: String, value: Value): Expected<String, None> {
    checkThread()
    return map.setStyleProjectionProperty(property, value)
  }

  override fun cameraForCoordinates(
    points: List<Point>,
    edgeInsets: EdgeInsets,
    zoom: Double?,
    pitch: Double?
  ): CameraOptions {
    checkThread()
    return map.cameraForCoordinates(points, edgeInsets, zoom, pitch)
  }

  override fun cameraForCoordinates(
    points: List<Point>,
    camera: CameraOptions,
    box: ScreenBox
  ): CameraOptions {
    checkThread()
    return map.cameraForCoordinates(points, camera, box)
  }

  override fun cameraForGeometry(
    geometry: Geometry,
    edgeInsets: EdgeInsets,
    zoom: Double?,
    pitch: Double?
  ): CameraOptions {
    checkThread()
    return map.cameraForGeometry(geometry, edgeInsets, zoom, pitch)
  }

  override fun getElevation(point: Point): Double? {
    checkThread()
    return map.getElevation(point)
  }

  override fun setRenderCacheOptions(options: RenderCacheOptions) {
    checkThread()
    map.renderCacheOptions = options
  }

  override fun getRenderCacheOptions(): RenderCacheOptions {
    checkThread()
    return map.renderCacheOptions
  }

  override fun setViewAnnotationPositionsUpdateListener(listener: ViewAnnotationPositionsUpdateListener?) {
    checkThread()
    map.setViewAnnotationPositionsUpdateListener(listener)
  }

  override fun addViewAnnotation(
    identifier: String,
    options: ViewAnnotationOptions
  ): Expected<String, None> {
    checkThread()
    return map.addViewAnnotation(identifier, options)
  }

  override fun updateViewAnnotation(
    identifier: String,
    options: ViewAnnotationOptions
  ): Expected<String, None> {
    checkThread()
    return map.updateViewAnnotation(identifier, options)
  }

  override fun removeViewAnnotation(identifier: String): Expected<String, None> {
    checkThread()
    return map.removeViewAnnotation(identifier)
  }

  override fun getViewAnnotationOptions(identifier: String): Expected<String, ViewAnnotationOptions> {
    checkThread()
    return map.getViewAnnotationOptions(identifier)
  }

  override fun coordinateBoundsForCamera(cameraOptions: CameraOptions): CoordinateBounds {
    checkThread()
    return map.coordinateBoundsForCamera(cameraOptions)
  }

  override fun coordinateBoundsForCameraUnwrapped(cameraOptions: CameraOptions): CoordinateBounds {
    checkThread()
    return map.coordinateBoundsForCamera(cameraOptions)
  }

  override fun coordinateBoundsZoomForCameraUnwrapped(cameraOptions: CameraOptions): CoordinateBoundsZoom {
    checkThread()
    return map.coordinateBoundsZoomForCameraUnwrapped(cameraOptions)
  }

  override fun pixelsForCoordinates(coordinates: MutableList<Point>): MutableList<ScreenCoordinate> {
    checkThread()
    return map.pixelsForCoordinates(coordinates)
  }

  override fun setGestureInProgress(gestureInProgress: Boolean) {
    checkThread()
    map.isGestureInProgress = gestureInProgress
  }

  override fun isGestureInProgress(): Boolean {
    checkThread()
    return map.isGestureInProgress
  }

  override fun setBounds(boundOptions: CameraBoundsOptions): Expected<String, None> {
    checkThread()
    return map.setBounds(boundOptions)
  }

  override fun getBounds(): CameraBounds {
    checkThread()
    return map.bounds
  }

  override fun setPrefetchZoomDelta(zoomDelta: Byte) {
    checkThread()
    map.prefetchZoomDelta = zoomDelta
  }

  override fun getPrefetchZoomDelta(): Byte {
    checkThread()
    return map.prefetchZoomDelta
  }

  override fun setNorthOrientation(northOrientation: NorthOrientation) {
    checkThread()
    map.setNorthOrientation(northOrientation)
  }

  override fun setConstrainMode(constrainMode: ConstrainMode) {
    checkThread()
    map.setConstrainMode(constrainMode)
  }

  override fun setViewportMode(viewportMode: ViewportMode) {
    checkThread()
    map.setViewportMode(viewportMode)
  }

  override fun getMapOptions(): MapOptions {
    checkThread()
    return map.mapOptions
  }

  override fun triggerRepaint() {
    checkThread()
    map.triggerRepaint()
  }

  override fun setStyleLayerProperty(
    layerId: String,
    property: String,
    value: Value
  ): Expected<String, None> {
    checkThread()
    return map.setStyleLayerProperty(layerId, property, value)
  }

  override fun pixelForCoordinate(pixel: Point): ScreenCoordinate {
    checkThread()
    return map.pixelForCoordinate((pixel))
  }

  override fun coordinateForPixel(screenCoordinate: ScreenCoordinate): Point {
    checkThread()
    return map.coordinateForPixel(screenCoordinate)
  }

  override fun getDebug(): List<MapDebugOptions> {
    checkThread()
    return map.debug
  }

  override fun setDebug(list: List<MapDebugOptions>, debugActive: Boolean) {
    checkThread()
    map.setDebug(list, debugActive)
  }

  override fun addStyleLayer(
    parameters: Value,
    layerPosition: LayerPosition?
  ): Expected<String, None> {
    checkThread()
    return map.addStyleLayer(parameters, layerPosition)
  }

  override fun addStyleCustomLayer(
    layerId: String,
    layerHost: CustomLayerHost,
    layerPosition: LayerPosition?
  ): Expected<String, None> {
    checkThread()
    return map.addStyleCustomLayer(layerId, layerHost, layerPosition)
  }

  override fun addPersistentStyleLayer(
    properties: Value,
    layerPosition: LayerPosition?
  ): Expected<String, None> {
    checkThread()
    return map.addPersistentStyleLayer(properties, layerPosition)
  }

  override fun addPersistentStyleCustomLayer(
    layerId: String,
    layerHost: CustomLayerHost,
    layerPosition: LayerPosition?
  ): Expected<String, None> {
    checkThread()
    return map.addPersistentStyleCustomLayer(layerId, layerHost, layerPosition)
  }

  override fun isStyleLayerPersistent(layerId: String): Expected<String, Boolean> {
    checkThread()
    return map.isStyleLayerPersistent(layerId)
  }

  override fun moveStyleLayer(layerId: String, layerPosition: LayerPosition?): Expected<String, None> {
    checkThread()
    return map.moveStyleLayer(layerId, layerPosition)
  }

  override fun getResourceOptions(): ResourceOptions {
    checkThread()
    return map.resourceOptions
  }

  override fun setStyleJSON(json: String) {
    checkThread()
    map.styleJSON = json
  }

  override fun getStyleJSON(): String {
    checkThread()
    return map.styleJSON
  }

  override fun getStyleURI(): String {
    checkThread()
    return map.styleURI
  }

  override fun setStyleURI(uri: String) {
    checkThread()
    map.styleURI = uri
  }

  override fun getStyleDefaultCamera(): CameraOptions {
    checkThread()
    return map.styleDefaultCamera
  }

  override fun getStyleTransition(): TransitionOptions {
    checkThread()
    return map.styleTransition
  }

  override fun setStyleTransition(transitionOptions: TransitionOptions) {
    checkThread()
    map.styleTransition = transitionOptions
  }

  override fun removeStyleLayer(layerId: String): Expected<String, None> {
    checkThread()
    return map.removeStyleLayer(layerId)
  }

  override fun styleLayerExists(layerId: String): Boolean {
    checkThread()
    return map.styleLayerExists(layerId)
  }

  override fun getStyleLayerProperty(layerId: String, property: String): StylePropertyValue {
    checkThread()
    return map.getStyleLayerProperty(layerId, property)
  }

  override fun setStyleLayerProperties(layerId: String, properties: Value): Expected<String, None> {
    checkThread()
    return map.setStyleLayerProperties(layerId, properties)
  }

  override fun addStyleSource(sourceId: String, source: Value): Expected<String, None> {
    checkThread()
    return map.addStyleSource(sourceId, source)
  }

  override fun getStyleSourceProperties(sourceId: String): Expected<String, Value> {
    checkThread()
    return map.getStyleSourceProperties(sourceId)
  }

  override fun updateStyleImageSourceImage(sourceId: String, image: Image): Expected<String, None> {
    checkThread()
    return map.updateStyleImageSourceImage(sourceId, image)
  }

  override fun getStyleLayerProperties(layerId: String): Expected<String, Value> {
    checkThread()
    return map.getStyleLayerProperties(layerId)
  }

  override fun removeStyleSource(sourceId: String): Expected<String, None> {
    checkThread()
    return map.removeStyleSource(sourceId)
  }

  override fun setStyleCustomGeometrySourceTileData(
    sourceId: String,
    tileId: CanonicalTileID,
    featureCollection: MutableList<Feature>
  ): Expected<String, None> {
    checkThread()
    return map.setStyleCustomGeometrySourceTileData(sourceId, tileId, featureCollection)
  }

  override fun styleSourceExists(sourceId: String): Boolean {
    checkThread()
    return map.styleSourceExists(sourceId)
  }

  override fun setStyleLight(light: Value): Expected<String, None> {
    checkThread()
    return map.setStyleLight(light)
  }

  override fun setStyleLightProperty(property: String, value: Value): Expected<String, None> {
    checkThread()
    return map.setStyleLightProperty(property, value)
  }

  override fun getStyleLightProperty(property: String): StylePropertyValue {
    checkThread()
    return map.getStyleLightProperty(property)
  }

  override fun getStyleImage(imageId: String): Image? {
    checkThread()
    return map.getStyleImage(imageId)
  }

  override fun removeStyleImage(imageId: String): Expected<String, None> {
    checkThread()
    return map.removeStyleImage(imageId)
  }

  override fun hasStyleImage(imageId: String): Boolean {
    checkThread()
    return map.hasStyleImage(imageId)
  }

  override fun queryRenderedFeatures(
    shape: MutableList<ScreenCoordinate>,
    options: RenderedQueryOptions,
    callback: QueryFeaturesCallback
  ) {
    checkThread()
    map.queryRenderedFeatures(shape, options, callback)
  }

  override fun queryRenderedFeatures(
    screenBox: ScreenBox,
    options: RenderedQueryOptions,
    callback: QueryFeaturesCallback
  ) {
    checkThread()
    map.queryRenderedFeatures(screenBox, options, callback)
  }

  override fun queryRenderedFeatures(
    pixel: ScreenCoordinate,
    options: RenderedQueryOptions,
    callback: QueryFeaturesCallback
  ) {
    checkThread()
    map.queryRenderedFeatures(pixel, options, callback)
  }

  override fun queryRenderedFeatures(
    geometry: RenderedQueryGeometry,
    options: RenderedQueryOptions,
    callback: QueryFeaturesCallback
  ): Cancelable {
    checkThread()
    return map.queryRenderedFeatures(geometry, options, callback)
  }

  override fun querySourceFeatures(
    sourceId: String,
    options: SourceQueryOptions,
    callback: QueryFeaturesCallback
  ) {
    checkThread()
    map.querySourceFeatures(sourceId, options, callback)
  }

  override fun queryFeatureExtensions(
    sourceIdentifier: String,
    feature: Feature,
    extension: String,
    extensionField: String,
    args: HashMap<String, Value>?,
    callback: QueryFeatureExtensionCallback
  ) {
    checkThread()
    map.queryFeatureExtensions(sourceIdentifier, feature, extension, extensionField, args, callback)
  }

  override fun setFeatureState(
    sourceId: String,
    sourceLayerId: String?,
    featureId: String,
    state: Value
  ) {
    checkThread()
    map.setFeatureState(sourceId, sourceLayerId, featureId, state)
  }

  override fun getFeatureState(
    sourceId: String,
    sourceLayerId: String?,
    featureId: String,
    callback: QueryFeatureStateCallback
  ) {
    checkThread()
    map.getFeatureState(sourceId, sourceLayerId, featureId, callback)
  }

  override fun getFreeCameraOptions(): FreeCameraOptions {
    checkThread()
    return map.freeCameraOptions
  }

  override fun setCamera(options: FreeCameraOptions) {
    checkThread()
    map.setCamera(options)
  }

  override fun invalidateStyleCustomGeometrySourceTile(
    sourceId: String,
    tileId: CanonicalTileID
  ): Expected<String, None> {
    checkThread()
    return map.invalidateStyleCustomGeometrySourceTile(sourceId, tileId)
  }

  override fun setStyleSourceProperties(
    sourceId: String,
    properties: Value
  ): Expected<String, None> {
    checkThread()
    return map.setStyleSourceProperties(sourceId, properties)
  }

  override fun removeFeatureState(
    sourceId: String,
    sourceLayerId: String?,
    featureId: String,
    stateKey: String?
  ) {
    checkThread()
    return map.removeFeatureState(sourceId, sourceLayerId, featureId, stateKey)
  }

  override fun setMemoryBudget(memoryBudget: MapMemoryBudget?) {
    checkThread()
    map.setMemoryBudget(memoryBudget)
  }

  override fun addStyleCustomGeometrySource(
    sourceId: String,
    options: CustomGeometrySourceOptions
  ): Expected<String, None> {
    checkThread()
    return map.addStyleCustomGeometrySource(sourceId, options)
  }

  override fun addStyleImage(
    imageId: String,
    scale: Float,
    image: Image,
    sdf: Boolean,
    stretchX: MutableList<ImageStretches>,
    stretchY: MutableList<ImageStretches>,
    content: ImageContent?
  ): Expected<String, None> {
    checkThread()
    return map.addStyleImage(imageId, scale, image, sdf, stretchX, stretchY, content)
  }

  override fun reduceMemoryUse() {
    checkThread()
    map.reduceMemoryUse()
  }

  override fun isUserAnimationInProgress(): Boolean {
    checkThread()
    return map.isUserAnimationInProgress
  }

  override fun getStyleSourceProperty(sourceId: String, property: String): StylePropertyValue {
    checkThread()
    return map.getStyleSourceProperty(sourceId, property)
  }

  override fun isStyleLoaded(): Boolean {
    checkThread()
    return map.isStyleLoaded
  }

  override fun isMapLoaded(): Boolean {
    checkThread()
    return map.isMapLoaded
  }

  override fun setStyleSourceProperty(
    sourceId: String,
    property: String,
    value: Value
  ): Expected<String, None> {
    checkThread()
    return map.setStyleSourceProperty(sourceId, property, value)
  }

  override fun coordinateBoundsZoomForCamera(camera: CameraOptions): CoordinateBoundsZoom {
    checkThread()
    return map.coordinateBoundsZoomForCamera(camera)
  }

  override fun getStyleLayers(): List<StyleObjectInfo> {
    checkThread()
    return map.styleLayers
  }

  override fun getStyleSources(): List<StyleObjectInfo> {
    checkThread()
    return map.styleSources
  }

  override fun subscribe(observer: Observer, events: MutableList<String>) {
    checkThread()
    map.subscribe(observer, events)
  }

  override fun unsubscribe(observer: Observer, events: MutableList<String>) {
    checkThread()
    map.unsubscribe(observer, events)
  }

  override fun unsubscribe(observer: Observer) {
    checkThread()
    map.unsubscribe(observer)
  }

  private fun checkThread(){
    if(!threadChecker.isMainThread()){
      throw WorkerThreadException()
    }
  }
}