/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 * Copyright 2019-2020 the original author or authors.
 */

package org.quickperf.jvm.annotations;

import org.quickperf.jvm.allocation.AllocationUnit;
import org.quickperf.jvm.gc.GC;
import org.quickperf.writer.DefaultWriterFactory;
import org.quickperf.writer.WriterFactory;

import java.lang.annotation.Annotation;

public class JvmAnnotationBuilder {

    private JvmAnnotationBuilder() {}

    public static ExpectNoJvmIssue expectNoJvmIssue() {
        return new ExpectNoJvmIssue() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return ExpectNoJvmIssue.class;
            }
            @Override
            public int score() {
                return 60;
            }
        };
    }

    public static ExpectNoJvmIssue expectNoJvmIssue(final int score) {
        return new ExpectNoJvmIssue() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return ExpectNoJvmIssue.class;
            }
            @Override
            public int score() {
                return score;
            }
        };
    }

    public static HeapSize heapSize(final int value, final AllocationUnit unit) {
        return new HeapSize() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return HeapSize.class;
            }
            @Override
            public int value() {
                return value;
            }
            @Override
            public AllocationUnit unit() {
                return unit;
            }
        };
    }

    public static JvmOptions jvmOptions(final String value) {
        return new JvmOptions() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return JvmOptions.class;
            }
            @Override
            public String value() {
                return value;
            }
        };
    }

    public static UseGC useGC(final GC gc) {
        return new UseGC() {
            @Override
            public GC value() {
                return gc;
            }
            @Override
            public Class<? extends Annotation> annotationType() {
                return UseGC.class;
            }
        };
    }

    public static EnableGcLogging enableGcLogging() {
        return new EnableGcLogging(){
            @Override
            public Class<? extends Annotation> annotationType() {
                return EnableGcLogging.class;
            }
        };
    }

    public static ExpectMaxHeapAllocation expectMaxHeapAllocation(final double value, final AllocationUnit unit) {
        return new ExpectMaxHeapAllocation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return ExpectMaxHeapAllocation.class;
            }
            @Override
            public double value() {
                return value;
            }
            @Override
            public AllocationUnit unit() {
                return unit;
            }
        };
    }

    public static MeasureHeapAllocation measureHeapAllocation(
              final String format
            , final Class<? extends WriterFactory> writerFactoryClass) {
        return new MeasureHeapAllocation() {
            @Override
            public String format() {
                return format;
            }

            @Override
            public Class<? extends WriterFactory> writerFactory() {
                return writerFactoryClass;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return MeasureHeapAllocation.class;
            }
        };
    }

    public static MeasureHeapAllocation measureHeapAllocation() {
        return measureHeapAllocation(MeasureHeapAllocation.QUICK_PERF_MEASURED_HEAP_ALLOCATION_DEFAULT_FORMAT, DefaultWriterFactory.class);
    }

    public static MeasureHeapAllocation measureHeapAllocation(final String format) {
        return measureHeapAllocation(format, DefaultWriterFactory.class);
    }

    public static MeasureHeapAllocation measureHeapAllocation(final Class<? extends WriterFactory> writerFactoryClass) {
        return measureHeapAllocation(MeasureHeapAllocation.QUICK_PERF_MEASURED_HEAP_ALLOCATION_DEFAULT_FORMAT, writerFactoryClass);
    }

    public static MeasureRSS measureRSS(){
        return  new MeasureRSS() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return MeasureRSS.class;
            }
        };
    }

    public static ExpectMaxRSS expectMaxRSS(final double value, final AllocationUnit unit) {
        return new ExpectMaxRSS() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return ExpectMaxRSS.class;
            }
            @Override
            public double value() {
                return value;
            }
            @Override
            public AllocationUnit unit() {
                return unit;
            }
        };
    }

    public static ExpectNoHeapAllocation expectNoHeapAllocation() {
        return new ExpectNoHeapAllocation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return ExpectNoHeapAllocation.class;
            }
        };
    }

    public static ProfileJvm profileJvm() {
        return new ProfileJvm() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return ProfileJvm.class;
            }
        };
    }

    public static Xms xms(final int value, final AllocationUnit unit) {
        return new Xms() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Xms.class;
            }
            @Override
            public int value() {
                return value;
            }
            @Override
            public AllocationUnit unit() {
                return unit;
            }
        };
    }

    public static Xmx xmx(final int value, final AllocationUnit unit) {
        return new Xmx() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Xmx.class;
            }
            @Override
            public int value() {
                return value;
            }
            @Override
            public AllocationUnit unit() {
                return unit;
            }
        };
    }

}
