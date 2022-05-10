package com.mapbox.maps.exception

import java.lang.RuntimeException

class WorkerThreadException : RuntimeException(
  """
  The exception that is thrown when an application attempts to 
  perform a map operation on a worked thread.
  """.trimIndent()
)